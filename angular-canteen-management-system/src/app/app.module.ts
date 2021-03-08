import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { ItemComponent } from './item/item.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { CustomerPortalComponent } from './customer-portal/customer-portal.component';
import { VendorPortalComponent } from './vendor-portal/vendor-portal.component';
import { CustomerListComponent } from './vendor-portal/customer-list/customer-list.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CustomerDetailsComponent } from './customer-portal/customer-details/customer-details.component';
import { AddMoneyComponent } from './customer-portal/add-money/add-money.component';
import { PlaceOrderComponent } from './customer-portal/place-order/place-order.component';
import { CommonModule } from '@angular/common';
import { ViewTransactionComponent } from './customer-portal/view-transaction/view-transaction.component';
import { VendorDetailsComponent } from './vendor-portal/vendor-details/vendor-details.component';
import { UpdateTransactionComponent } from './vendor-portal/update-transaction/update-transaction.component';
import { UpdateMenuComponent } from './vendor-portal/update-menu/update-menu.component';
import { AddItemComponent } from './vendor-portal/update-menu/add-item/add-item.component';
import { UpdateCustomerComponent } from './customer-portal/customer-details/update-customer/update-customer.component';
import { HomePageComponent } from './home-page/home-page.component';
import { ForgetPasswordComponent } from './login/forget-password/forget-password.component';
import { UpdateVendorComponent } from './vendor-portal/vendor-details/update-vendor/update-vendor.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    ItemComponent,
    LoginComponent,
    RegisterComponent,
    CustomerPortalComponent,
    VendorPortalComponent,
    CustomerListComponent,
    CustomerDetailsComponent,
    AddMoneyComponent,
    PlaceOrderComponent,
    ViewTransactionComponent,
    VendorDetailsComponent,
    UpdateTransactionComponent,
    UpdateMenuComponent,
    AddItemComponent,
    UpdateCustomerComponent,
    HomePageComponent,
    ForgetPasswordComponent,
    UpdateVendorComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    CommonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
