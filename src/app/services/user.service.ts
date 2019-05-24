import { Injectable } from '@angular/core';
import { UserDTO } from 'src/app/dto/userdto';
import { HttpClient } from '@angular/common/http';
import { AbstractService } from './abstractservice';

@Injectable({
  providedIn: 'root'
})

export class UserService extends AbstractService<UserDTO> {

    constructor(http: HttpClient) {
        super(http);
        this.type = 'user';
        this.port = '8081';
    }

}
