import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import {LoginService} from 'src/services/login.service';
import { UserDTO } from 'src/dto/UserDTO';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private idUtenteLocale: number;
  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {

  }

  login(f: NgForm): void {
    this.loginService.login(f.value.username, f.value.password).subscribe((response) => {

      if(response != null) {
        this.idUtenteLocale = response.id;
        console.log(this.idUtenteLocale);
      }
    });
  }
}
