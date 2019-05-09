import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';
import { UserDTO } from '../../dto/userdto';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

    userDTO: UserDTO;
    constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
      this.userDTO = new UserDTO();
  }

  register(): void {
      this.loginService.register(this.userDTO).subscribe((response) => {
      if (response != null) {
         this.router.navigateByUrl('/login');
      }
      });
}
}
