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
    isCollapsed = false;
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

     openNav() {
     document.getElementById('mySidenav').style.width = '100%';
     document.getElementById('main').style.marginLeft = '95%';
     }

     closeNav() {
     document.getElementById('mySidenav').style.width = '0';
     document.getElementById('main').style.marginLeft = '0';
     }

    collapse() {
        if (this.isCollapsed === false) {
            this.isCollapsed = true;
        } else { this.isCollapsed = false; }
    }
}
