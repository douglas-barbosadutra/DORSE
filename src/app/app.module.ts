import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { LayoutModule } from './layout/layout.module';
import { TutorDashboardModule } from './tutor-dashboard/tutor-dashboard.module';
import { HttpClientModule } from '@angular/common/http';
import { LoginModule } from './login/login.module';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,

    LoginModule,
    LayoutModule,
    TutorDashboardModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
