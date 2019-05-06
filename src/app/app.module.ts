import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { UsersComponent } from '../components/user/users.component';
import { DashboardComponent } from '../components/dashboard/dashboard.component';
import { MessagesComponent } from '../components/messages/messages.component';
import { UserDetailComponent } from '../components/user/user-detail/user-detail.component';

import { UserService } from 'src/services/user.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    DashboardComponent,
    MessagesComponent,
    UserDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
