import { Injectable } from '@angular/core';
import { ApartmentDTO } from '../dto/apartmentdto';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApartmentService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<ApartmentDTO[]> {
      return this.http.get<ApartmentDTO[]>('http://localhost:8080/apartment/getall');
  }

  getApartment(id: number): Observable<ApartmentDTO> {
      return this.http.get<ApartmentDTO>('http://localhost:8080/apartment/read?id=' + id);
  }

  delete(id: number): Observable<any>{
      return this.http.delete('http://localhost:8080/apartment/delete?id=' + id);
  }
  
  insert(apartment: ApartmentDTO): Observable<any> {
      return this.http.post('http://localhost:8080/apartment/insert', apartment);
  }
  
  update(apartment: ApartmentDTO): Observable<any> {
      return this.http.put('http://localhost:8080/apartment/update', apartment);
  }
}
