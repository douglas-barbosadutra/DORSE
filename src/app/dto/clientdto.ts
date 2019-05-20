import { ApartmentDTO } from './apartmentdto';
import { TutorDTO } from './tutordto';

export class ClientDTO {

    id: number;

    name: string;

    surname: string;

    birthdate: Date;

    telnumber: string ;

    apartmentDTO: ApartmentDTO;

    tutorDTO: TutorDTO;
}
