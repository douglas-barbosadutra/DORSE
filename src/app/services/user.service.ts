import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserDTO } from '../models//user';

@Injectable()
export class UserService {
    
  private usersUrl: string;

  constructor(private http: HttpClient) {
      this.usersUrl = 'http://localhost:8080/users';
  }
  
  public findAll(): Observable<UserDTO[]> {
      return this.http.get<UserDTO[]>(this.usersUrl);
  }
}
