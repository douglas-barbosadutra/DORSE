import { NgModule, ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './login/registration/registration.component';



const routes: Routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full'},
    { path: 'login', component: LoginComponent},
    { path: 'register', component: RegistrationComponent}
];
export const routingModule: ModuleWithProviders = RouterModule.forRoot(routes);

@NgModule({
    imports: [
        RouterModule.forRoot(routes),

    ],

  exports: [
      RouterModule
    ]
})
export class AppRoutingModule { }
