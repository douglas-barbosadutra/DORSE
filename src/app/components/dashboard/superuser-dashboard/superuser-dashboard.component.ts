import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/app/dto/userdto';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-superuser-dashboard',
  templateUrl: './superuser-dashboard.component.html',
  styleUrls: [ './superuser-dashboard.component.css' ]
})
export class SuperuserDashboardComponent implements OnInit {

  users: UserDTO[] = [];

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.getUsers();
  }

  getUsers(): void {
    this.userService.getUsers().subscribe(users => this.users = users);
  }
}
