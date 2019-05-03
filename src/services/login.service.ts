    import { Injectable } from '@angular/core';
    import { HttpClient, HttpParams } from '@angular/common/http';
    import { Observable } from 'rxjs';
    import { UserDTO } from '../dto/UserDTO';

    @Injectable({
    providedIn: 'root'
    })
    export class LoginService {

    constructor(private http: HttpClient) { }

    login(username: string, password: string): Observable<UserDTO> {
        const params = new HttpParams().set('username', username).set('password', password);
        return this.http.post<UserDTO>('http://localhost:8080/login', params);
        }
    }
