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
import { MenuComponent } from '../app/components/menu/menu.component';
import { LoginComponent } from '../app/components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { TutorDashboardComponent } from './components/dashboard/tutor-dashboard/tutor-dashboard.component';
import { SuperuserDashboardComponent } from './components/dashboard/superuser-dashboard/superuser-dashboard.component';
import { OperatorDashboardComponent } from './components/dashboard/operator-dashboard/operator-dashboard.component';
import { RoomComponent } from './components/room/room.component';
import { RoomDetailsComponent } from './components/room/room-details/room-details.component';
import { ApartmentComponent } from './components/apartment/apartment.component';
import { TutorNavbarComponent } from './components/navbar/tutor-navbar/tutor-navbar.component';
import { OperatorNavbarComponent } from './components/navbar/operator-navbar/operator-navbar.component';
import { SuperuserNavbarComponent } from './components/navbar/superuser-navbar/superuser-navbar.component';
import { ApartmentDetailsComponent } from './components/apartment/apartment-details/apartment-details.component';
import { ThingComponent } from './components/thing/thing.component';
import { ThingDetailsComponent } from './components/thing/thing-details/thing-details.component';



@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    MessagesComponent,
    UserDetailComponent,
    HeaderComponent,
    MenuComponent,
    LoginComponent,
    RegistrationComponent,
    TutorDashboardComponent,
    SuperuserDashboardComponent,
    OperatorDashboardComponent,
    RoomComponent,
    RoomDetailsComponent,
    ApartmentComponent,
    ApartmentDetailsComponent,
    TutorNavbarComponent,
    OperatorNavbarComponent,
    SuperuserNavbarComponent,
    ThingComponent,
    ThingDetailsComponent

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
