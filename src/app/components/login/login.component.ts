import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {

  }

    login(f: NgForm): void {
        this.loginService.login(f.value.username, f.value.username).subscribe((response) => {
        if (response != null) {
            // TOFIX
            if (response.userType.toString() === 'SUPERUSER') {
                console.log('entra nel secondo if');
                this.router.navigateByUrl('/dashboard');
            }
        }
        });
  }
}
