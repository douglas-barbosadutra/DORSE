import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TutorDashboardComponent } from './tutor-dashboard.component';
import { TutorDashboardRoutingModule } from './tutor-dashboard-routing.module';
import { ApartmentComponent } from './apartment/apartment.component';
import { RoomComponent } from './room/room.component';
import { ThingComponent } from './thing/thing.component';
import { ItemComponent } from './item/item.component';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ClientComponent } from './client/client.component';
import { ReportComponent } from './report/report.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { ReportDetailsComponent } from './report/report-details/report-details.component';
import { ContractConditionsComponent } from './contract-conditions/contract-conditions.component';



@NgModule({

    declarations: [
        TutorDashboardComponent,
        ApartmentComponent,
        RoomComponent,
        ThingComponent,
        ItemComponent,
        ClientComponent,
        ReportComponent,
        NotificationsComponent,
        ReportDetailsComponent,
        ContractConditionsComponent
    ],

    imports: [
        CommonModule,
        TutorDashboardRoutingModule,
        FormsModule,
        NgbModule
    ],

    exports: [
    ]
})

export class TutorDashboardModule { }
