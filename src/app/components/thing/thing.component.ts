        import { Component, OnInit } from '@angular/core';
        import { ThingDTO } from 'src/app/dto/thingdto';
        import { ThingService } from 'src/app/services/thing.service';

        @Component({
    selector: 'app-thing',
    templateUrl: './thing.component.html',
    styleUrls: ['./thing.component.css']
    })
    export class ThingComponent implements OnInit {

         things: ThingDTO[];
         thing: ThingDTO;

    constructor(private thingService: ThingService) { }

    ngOnInit() {
        this.getAll();
        this.thing = new ThingDTO();
    }


    getAll(): void {
        this.thingService.getAll()
        .subscribe(things => this.things = things);
    }

    // Subscribe execute getUser() as soon as delete gets a response
    delete(id: number ) {
        this.thingService.delete(id).subscribe(
            () => this.getAll()
        );
    }

    insert(description: string): void {
        this.thing.description = description;
        this.thingService.insert(this.thing)
        .subscribe(thing => this.getAll());
    }

    }
