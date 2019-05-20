import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { EventDTO } from '../dto/eventdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EventService extends AbstractService<EventDTO> {
    
    type = 'item';
    ob: string;

  constructor(http: HttpClient) {
      super(http);
  }
  
  getAllByItemAndDate(id: number, date: Date): Observable<EventDTO>[] {
          this.ob = JSON.stringify({id:id, date:date});
          return this.http.post<any>('http://localhost:8080/event/event', this.ob);
}
