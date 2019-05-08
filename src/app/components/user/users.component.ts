        import { Component, OnInit } from '@angular/core';
        import { UserDTO } from 'src/app/dto/userdto';
        import { UserService } from 'src/app/services/user.service';

        @Component({
        selector: 'app-users',
        templateUrl: './users.component.html',
        styleUrls: ['./users.component.css']
        })
        export class UsersComponent implements OnInit {

    users: UserDTO[];

    selectedUser: UserDTO;

        onSelect(user: UserDTO): void {
        this.selectedUser = user;
        }

        constructor(private userService: UserService) { }

        ngOnInit() {
        this.getUsers();

        }

    getUsers(): void {
        this.userService.getUsers()
        .subscribe(users => this.users = users);
    }

    delete(id: number ) {
        console.log('user.ts ok');
        this.userService.delete(id);

    }




        }
