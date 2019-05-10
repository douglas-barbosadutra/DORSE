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
        this.getAll();
        }

    getAll(): void {
        this.userService.getAll()
        .subscribe(users => this.users = users);
    }

    // Subscribe execute getUser() as soon as delete gets a response
    delete(id: number ) {
        this.userService.delete(id).subscribe(
            () => this.getAll()
        );
    }




        }
