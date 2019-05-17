
import { AbstractService } from 'src/app/services/abstractservice';

export abstract class AbstractComponent<DTO> {
    route: any;

  constructor(public service: AbstractService<DTO>) {
   }

    dtolist: DTO[];
    dto: DTO;
    insdto: any;
    currentEntity: string;
    id: number;
    selecteddto: DTO;

    onSelect(dto: DTO): void {
        this.selecteddto = dto;
        }

    getAll() {
        this.service.getAll().subscribe(dtolist => this.dtolist = dtolist);
    }

    getAllBy(): DTO[] {
        this.id = JSON.parse(localStorage.getItem(this.currentEntity)).id;
        this.service.getAllBy(this.id).subscribe(dtolist => this.dtolist = dtolist);
        return this.dtolist;
    }

    delete(id: number ) {
        this.service.delete(id).subscribe(dto => this.getAllBy());
    }

    insert() {
        this.service.insert(this.insdto).subscribe(insdto => this.getAllBy());
    }

   read(): DTO {
      const id = +this.route.snapshot.paramMap.get('id');
      this.service.read(id).subscribe(dto => this.dto = dto);
      return this.dto;
  }
    update(dto: DTO): void {
    this.service.update(dto).subscribe(dto => this.dto = dto);
  }
}
