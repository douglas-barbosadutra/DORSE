import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

enum UserType { SUPERUSER, OPERATOR, TUTOR }

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

private idUtenteLocale: number;
  constructor(private loginService: LoginService, private router:  Router) { }

  ngOnInit(){

  }

  login(f: NgForm): void {
    this.loginService.login(f.value.username, f.value.password).subscribe((response) => {

      if(response != null){
        this.idUtenteLocale = response.id;
        console.log(this.idUtenteLocale);
        sessionStorage.setItem("idUser", JSON.stringify(this.idUtenteLocale));

        if(response.rank == OPERATOR)
          this.router.navigateByUrl("/homeUser");

        else if(response.rank == TUTOR)
          this.router.navigateByUrl("/homeAdmin");

        else
            this.router.navigateByUrl("/homeEmployee");
      }
      else{
        alert("user o pass errati");
      }
    });
  }
}
