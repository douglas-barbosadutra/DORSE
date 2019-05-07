import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { UsersComponent } from '../app/components/user/users.component';
import { DashboardComponent } from '../app/components/dashboard/dashboard.component';
import { MessagesComponent } from '../app/components/messages/messages.component';
import { UserDetailComponent } from '../app/components/user/user-detail/user-detail.component';
import { HeaderComponent } from '../app/components/header/header.component';
import { NavbarComponent } from '../app/components/navbar/navbar.component';
import { MenuComponent } from '../app/components/menu/menu.component';
import { LoginComponent } from '../app/components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';


@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    DashboardComponent,
    MessagesComponent,
    UserDetailComponent,
    HeaderComponent,
    NavbarComponent,
    MenuComponent,
    LoginComponent,
    RegistrationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
