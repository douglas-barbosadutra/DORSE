import { Component, OnInit } from '@angular/core';
import { ClientDTO } from 'src/app/dto/clientdto';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

    clients: ClientDTO[];
  constructor(private service: ClientService) {
  }

  ngOnInit() {
      this.clients = new Array<ClientDTO>();
      this.getAllBy();
  }

getAllBy() {
    this.service.getAllBy(+JSON.parse(localStorage.getItem('currentUser')).id).subscribe(clients => this.clients = clients);
}

    logout() {
        localStorage.clear();
    }
}
