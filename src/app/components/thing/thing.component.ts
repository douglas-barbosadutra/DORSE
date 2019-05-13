import { Component, OnInit } from '@angular/core';
import { ThingDTO } from 'src/app/dto/thingdto';
import { ThingService } from 'src/app/services/thing.service';
import { AbstractComponent } from '../abstract/abstract.component';

@Component({
    selector: 'app-thing',
    templateUrl: './thing.component.html',
    styleUrls: ['./thing.component.css']
    })
    export class ThingComponent extends AbstractComponent<ThingDTO> implements OnInit {


    constructor( service: ThingService) {
        super(service);
    }

    ngOnInit() {
        this.getAll();

    }
}
