import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TutorDashboardComponent } from './tutor-dashboard.component';
import { TutorDashboardRoutingModule } from './tutor-dashboard-routing.module';
import { ApartmentComponent } from './apartment/apartment.component';
import { ApartmentDetailsComponent } from './apartment-details/apartment-details.component';
import { RoomComponent } from './room/room.component';
import { ThingComponent } from './thing/thing.component';
import { ItemComponent } from './item/item.component';
import { FormsModule } from '@angular/forms';


@NgModule({

    declarations: [
        TutorDashboardComponent,
        ApartmentComponent,
        ApartmentDetailsComponent,
        RoomComponent,
        ThingComponent,
        ItemComponent
    ],

    imports: [
        CommonModule,
        TutorDashboardRoutingModule,
        FormsModule
    ],

    exports: [
    ]
})

export class TutorDashboardModule { }
