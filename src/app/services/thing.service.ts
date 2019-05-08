        import { Component, OnInit } from '@angular/core';
        import { ThingDTO } from 'src/app/dto/thingdto';
        import { ThingService } from 'src/app/services/thing.service';

        @Component({
        selector: 'app-thing',
        templateUrl: './thing.component.html',
        styleUrls: ['./thing.component.css']
        })
        export class ThingComponent implements OnInit {

    users: ThingDTO[];

    selectedUser: ThingDTO;

        onSelect(user: ThingDTO): void {
        this.selectedUser = user;
        }

        constructor(private thingService: ThingService) { }

        ngOnInit() {
        this.getUsers();

        }

    getUsers(): void {
        this.thingService.getUsers()
        .subscribe(users => this.users = users);