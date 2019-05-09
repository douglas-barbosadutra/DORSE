import { Injectable } from '@angular/core';
import { UserDTO } from 'src/app/dto/userdto';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

    constructor(private http: HttpClient) { }

    /* GET all users from the server */
    getUsers(): Observable<UserDTO[]> {
        return this.http.get<UserDTO[]>('http://localhost:8080/user/getall');
    }

    /* GET user from the server depending on id parameter */
    getUser(id: number): Observable<UserDTO> {
        return this.http.get<UserDTO>('http://localhost:8080/user/read?id=' + id);
    }

    /* DELETE user from the server depending on id parameter */
    delete(id: number): Observable<any> {
        return this.http.delete('http://localhost:8080/user/delete?id=' + id);
    }

}

