import { Injectable } from '@angular/core';
import { ApartmentDTO } from '../dto/apartment';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApartmentService {

  constructor(private http: HttpClient) { }
  
  getApartments(): Observable<ApartmentDTO[]> {
      return this.http.get<ApartmentDTO[]>('http://localhost:8080/apartment/getall');
  }
  
  getApartment(id: number): Observable<ApartmentDTO> {
      return this.http.get<ApartmentDTO>('http://localhost:8080/apartment/read?id=' + id);
  }
  
  delete(id: number) {
      this.http.delete('http://localhost:8080/apartment/delete?id=' + id).subscribe();
  }
}
