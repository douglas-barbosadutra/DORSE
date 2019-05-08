import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { UsersComponent } from '../app/components/user/users.component';
import { MessagesComponent } from '../app/components/messages/messages.component';
import { UserDetailComponent } from '../app/components/user/user-detail/user-detail.component';
import { HeaderComponent } from '../app/components/header/header.component';
import { NavbarComponent } from '../app/components/navbar/navbar.component';
import { MenuComponent } from '../app/components/menu/menu.component';
import { LoginComponent } from '../app/components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { TutorDashboardComponent } from './components/dashboard/tutor-dashboard/tutor-dashboard.component';
import { SuperuserDashboardComponent } from './components/dashboard/superuser-dashboard/superuser-dashboard.component';
import { OperatorDashboardComponent } from './components/dashboard/operator-dashboard/operator-dashboard.component';
import { ApartmentsComponent } from './components/apartments/apartments.component';
import { RoomComponent } from './components/room/room.component';
import { RoomDetailsComponent } from './components/room/room-details/room-details.component';


@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    MessagesComponent,
    UserDetailComponent,
    HeaderComponent,
    NavbarComponent,
    MenuComponent,
    LoginComponent,
    RegistrationComponent,
    TutorDashboardComponent,
    SuperuserDashboardComponent,
    OperatorDashboardComponent,
    ApartmentsComponent,
    RoomComponent,
    RoomDetailsComponent
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
