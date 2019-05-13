import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { LoginDTO } from 'src/app/dto/logindto';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    loginDTO: LoginDTO;


  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {

  }

    login(f: NgForm): void {
        this.loginDTO = new LoginDTO(f.value.username, f.value.password);
        this.userService.login(this.loginDTO).subscribe((user) => {
        if (user != null) {
            // TOFIX
            localStorage.setItem('currentUser', JSON.stringify(user));
            if (user.userType.toString() === 'SUPERUSER') {
                this.router.navigateByUrl('/superuser-dashboard');
            } else if (user.userType.toString() === 'OPERATOR') {
                this.router.navigateByUrl('/operator-dashboard');
            } else if (user.userType.toString() === 'TUTOR') {
                this.router.navigateByUrl('/tutor-dashboard');
            }
        }
        });
  }
}
