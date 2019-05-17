import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';
import { LoginDTO } from '../dto/logindto';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    loginDTO: LoginDTO;

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
  }

    login(f: NgForm): void {
        this.loginDTO = new LoginDTO(f.value.username, f.value.password);

        this.loginService.login(this.loginDTO).subscribe((user) => {

            if (user != null) {
            localStorage.setItem('currentUser', JSON.stringify(user));
            switch (user.userType.toString()) {
                    case 'SUPERUSER': {
                        this.router.navigateByUrl('/superuser-dashboard');
                        break;
                    }
                    case 'OPERATOR': {
                        this.router.navigateByUrl('/operator-dashboard');
                        break;
                    }
                    case 'TUTOR': {
                        this.router.navigateByUrl('/tutor-dashboard');
                        break;
                    }
                    case 'TESTUSER': {
                        this.router.navigateByUrl('/testuser-dashboard');
                        break;
                    }
                }
            }
        });
    }
}
