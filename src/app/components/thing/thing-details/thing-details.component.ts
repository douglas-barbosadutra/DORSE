        import { Component, OnInit, Input } from '@angular/core';
        import { ThingDTO } from 'src/app/dto/thingdto';
        import { ActivatedRoute } from '@angular/router';
        import { Location } from '@angular/common';
        import { ThingService } from 'src/app/services/thing.service';



        @Component({
    selector: 'app-thing-details',
    templateUrl: './thing-details.component.html',
    styleUrls: ['./thing-details.component.css']
    })
    export class ThingDetailsComponent implements OnInit {


        @Input() thing: ThingDTO;
    constructor(
  private route: ActivatedRoute,
  private thingService: ThingService,
  private location: Location
) {}

    ngOnInit(): void {
        this.read();

    }

     read(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.thingService.read(id)
    .subscribe(thing => this.thing = thing);
    }

    goBack(): void {
        this.location.back();
    }

    update(): void {
        this.thingService.update(this.thing)
        .subscribe(() => this.goBack());
    }
    }
