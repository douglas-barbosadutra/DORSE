import { ItemDTO } from './itemdto';
import { RoomDTO } from './roomdto';

export class ThingDTO {

    id: number;

    description: string;

    itemsDTO: ItemDTO[];

    roomDTO: RoomDTO;
}
