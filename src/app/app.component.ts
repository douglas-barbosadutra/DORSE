import { Component } from '@angular/core';
import { UserDTO } from './models/user';
import { UserService } from './services/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ANGULAR';
  
  users: UserDTO[];
  
  constructor(private userService: UserService) {
  }
  
  ngOnInit() {
      this.userService.findAll().subscribe(data => {
          this.users = data;
      });
    }
}