import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/model/customer';
import { Order } from 'src/app/model/Order';
import { CustomerService } from 'src/app/service/customer.service';
import { OrderService } from 'src/app/service/order.service';

@Component({
  selector: 'app-update-transaction',
  templateUrl: './update-transaction.component.html',
  styleUrls: ['./update-transaction.component.css']
})
export class UpdateTransactionComponent implements OnInit {

  allOrders: Order[] = [];
  vendorId: number;
  status=['Order Placed', 'Order Accepted','Order Cancelled'];
  currentOrder: Order = null;

  statusForm: FormGroup;
  changeStatus: FormControl;
  comments: FormControl;
  
  customer: Customer;

  constructor(private orderService: OrderService, private route: ActivatedRoute, private router: Router, private customerService: CustomerService) { }

  ngOnInit(): void {

    this.route.paramMap.subscribe(params =>
      {
        this.vendorId = +params.get("id");
      });

    this.orderService.getAllOrders().subscribe(data =>
      {
        this.allOrders = data;
        });
    
    this.changeStatus = new FormControl('Order Placed');
    this.comments = new FormControl('');
    this.statusForm = new FormGroup(
      {
        'changeStatus': this.changeStatus,
        'comments': this.comments
      });
  }

  getOrder(order: Order)
  {
    this.currentOrder = order;
  }

  onClick()
  {
    this.router.navigate(['vendor', this.vendorId]);
  }

  save()
  {
    this.currentOrder.status = this.statusForm.get('changeStatus').value;
    this.currentOrder.comments = this.statusForm.get('comments').value;
    this.orderService.updateOrder(this.currentOrder.orderId,this.currentOrder).subscribe(data =>{
      this.currentOrder = data;
    });

    if (this.currentOrder.status == "Order Cancelled")
    {
      // return money to customer's balance
      this.customerService.getCustomer(this.currentOrder.customerId).subscribe(data =>
        {
          this.customer = data;
          this.addMoneyBack();
        }, error => console.log(error));

      
    }
  }

  addMoneyBack()
  {
    this.customer.balance = this.currentOrder.amount+this.customer.balance;
      this.customerService.updateCustomer(this.currentOrder.customerId,this.customer).subscribe(data =>{
        console.log(data);
        this.customer = data;
      });
  }
}
