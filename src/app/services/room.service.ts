import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RoomDTO } from 'src/app/dto/roomdto';


@Injectable({
  providedIn: 'root'
})
export class RoomService {

    constructor(private http: HttpClient) { }

  
/* GET users from the server */
getRooms(): Observable<RoomDTO[]> {
return this.http.get<RoomDTO[]>('http://localhost:8080/room/getall');
}


/* GET user from the server depending on id parameter */
getRoom(id: number): Observable<RoomDTO> {
  return this.http.get<RoomDTO>('http://localhost:8080/room/read?id=' + id);
}

delete(id: number) {
        console.log('room service ok');
        this.http.delete('http://localhost:8080/room/delete?id=' + id).subscribe();
    }



}






