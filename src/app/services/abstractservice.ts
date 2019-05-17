import { Service } from './service';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

export abstract class AbstractService<DTO> implements Service<DTO> {

    type: string;

    constructor(protected http: HttpClient) {

    }

    getAllBy(id: number): Observable<DTO[]> {
        return this.http.get<DTO[]>('http://localhost:8080/' + this.type + '/getallby?id=' + id);
    }
    getAll(): Observable<DTO[]> {
        return this.http.get<DTO[]>('http://localhost:8080/' + this.type + '/getall');
    }

    read(id: number): Observable<DTO> {
        return this.http.get<DTO>('http://localhost:8080/' + this.type + '/read?id=' + id);
    }

    delete(id: number): Observable<any> {
        return this.http.delete('http://localhost:8080/' + this.type + '/delete?id=' + id);
    }

    insert(dto: DTO): Observable<any> {
        return this.http.post('http://localhost:8080/' + this.type + '/insert', dto);
    }

    update(dto: DTO): Observable<DTO> {
        return this.http.put<DTO>('http://localhost:8080/' + this.type + '/update', dto);

    }

}
