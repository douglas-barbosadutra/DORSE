
import { ActivatedRoute } from '@angular/router';
import { AbstractService } from 'src/app/services/abstractservice';
import { Location } from '@angular/common';

export abstract class AbstractDetailsComponent<DTO, SubDTO> {


    dto: DTO;
    subdto: SubDTO;
    subdtolist: SubDTO [];

  constructor(public route: ActivatedRoute, public service: AbstractService<DTO>, private location: Location) {
  }


  read(): DTO {
      const id = +this.route.snapshot.paramMap.get('id');
      this.service.read(id).subscribe(dto => this.dto = dto);
      return this.dto;
  }

  update(): void {
      this.service.update(this.dto).subscribe(() => this.read() );
  }

  goBack(): void {
      this.location.back();
  }

}
