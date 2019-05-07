import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { UsersComponent } from '../app/components/user/users.component';
import { DashboardComponent } from '../app/components/dashboard/dashboard.component';
import { UserDetailComponent } from '../app/components/user/user-detail/user-detail.component';
import { LoginComponent } from '../app/components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';


const routes: Routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent},
    { path: 'register', component: RegistrationComponent},
    { path: 'users', component: UsersComponent },
    { path: 'detail/:id', component: UserDetailComponent },
    { path: 'dashboard', component: DashboardComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
