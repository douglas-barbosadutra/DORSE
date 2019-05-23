import { Injectable } from '@angular/core';
import { UserDTO } from 'src/app/dto/userdto';
import { HttpClient, HttpParams } from '@angular/common/http';
import { AbstractService } from './abstractservice';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class UserService extends AbstractService<UserDTO> {

    constructor(shttp: HttpClient) {
        super(shttp);
        this.type = 'user';
    }

    insert(userDTO: UserDTO): Observable<any> {
        return this.http.post('http://localhost:8081/user/insert', userDTO);
    }
}
