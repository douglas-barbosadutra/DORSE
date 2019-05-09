import { Injectable } from '@angular/core';
import { ThingDTO } from 'src/app/dto/thingdto';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class ThingService {

        constructor(private http: HttpClient) {}

    /* GET all things from the server */
    getThings(): Observable<ThingDTO[]> {
        return this.http.get<ThingDTO[]>('http://localhost:8080/thing/getall');
    }


    /* GET thing from the server depending on id parameter */
    getThing(id: number): Observable<ThingDTO> {
        return this.http.get<ThingDTO>('http://localhost:8080/thing/read?id=' + id);
    }

    /* DELETE thing from the server depending on id parameter */
    delete(id: number): Observable<any> {
        return this.http.delete('http://localhost:8080/thing/delete?id=' + id);
    }
    insert(thing: ThingDTO): Observable<any> {
        return this.http.post('http://localhost:8080/thing/insert', thing);
    }
    update(thing: ThingDTO): Observable<any> {
        return this.http.put('http://localhost:8080/thing/update', thing);
    }
}
