import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainLayoutComponent } from './main-layout/main-layout.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MenuComponent } from './menu/menu.component';
import { ApartmentDropdownComponent } from './menu/apartment-dropdown/apartment-dropdown.component';
import { RoomDropdownComponent } from './menu/apartment-dropdown/room-dropdown/room-dropdown.component';

@NgModule({
    declarations: [
        MainLayoutComponent,
        FooterComponent,
        HeaderComponent,
        NavbarComponent,
        MenuComponent,
        ApartmentDropdownComponent,
        RoomDropdownComponent
    ],

    imports: [
        CommonModule,
        RouterModule,
        FormsModule,
        NgbModule
    ],

})
export class LayoutModule { }
