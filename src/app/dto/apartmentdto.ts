import { RoomDTO } from './roomdto';
import { TutorDTO } from './tutordto';

export class ApartmentDTO {

    id: number;

    address: string;

    roomsDTO: RoomDTO[];

    tutorDTO: TutorDTO;

}
