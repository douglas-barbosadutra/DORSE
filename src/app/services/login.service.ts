import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserDTO } from '../dto/userdto';
import { LoginDTO } from '../dto/logindto';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) {
   }

  login(loginDTO: LoginDTO): Observable<UserDTO> {
        return this.http.post<any>('http://localhost:8080/user/login', loginDTO);
  }
  
}
