
import { ActivatedRoute } from '@angular/router';
import { AbstractService } from 'src/app/services/abstractservice';
import { Location } from '@angular/common';


export abstract class AbstractDetailsComponent<DTO> {


    dto: DTO;

  constructor(public route: ActivatedRoute, public service: AbstractService<DTO>, private location: Location) {
  }


  read(): DTO {
      const id = +this.route.snapshot.paramMap.get('id');
      this.service.read(id).subscribe(dto => this.dto = dto);
      return this.dto;
  }

//   update(): void {
//       this.service.update(this.dto).subscribe(dto => this.dto = this.read() );
//   }

  goBack(): void {
      this.location.back();
  }

}
