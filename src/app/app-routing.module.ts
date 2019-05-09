import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsersComponent } from '../app/components/user/users.component';
import { UserDetailComponent } from '../app/components/user/user-detail/user-detail.component';
import { LoginComponent } from '../app/components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { SuperuserDashboardComponent } from './components/dashboard/superuser-dashboard/superuser-dashboard.component';
import { OperatorDashboardComponent } from './components/dashboard/operator-dashboard/operator-dashboard.component';
import { TutorDashboardComponent } from './components/dashboard/tutor-dashboard/tutor-dashboard.component';
import { ApartmentComponent } from './components/apartment/apartment.component';
import { RoomComponent } from './components/room/room.component';
import { ThingComponent } from './components/thing/thing.component';


const routes: Routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent},
    { path: 'register', component: RegistrationComponent},
    { path: 'users', component: UsersComponent },
    { path: 'detail/:id', component: UserDetailComponent },
    { path: 'superuser-dashboard', component: SuperuserDashboardComponent},
    { path: 'operator-dashboard', component: OperatorDashboardComponent},
    { path: 'tutor-dashboard', component: TutorDashboardComponent},
    { path: 'apartments', component: ApartmentComponent},
    { path: 'rooms', component: RoomComponent},
    { path: 'things', component: ThingComponent},
    ];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
