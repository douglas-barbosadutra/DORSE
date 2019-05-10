    import { Component, OnInit, Input } from '@angular/core';
    import { UserDTO } from 'src/app/dto/userdto';
    import { ActivatedRoute } from '@angular/router';
    import { Location } from '@angular/common';
    import { UserService } from 'src/app/services/user.service';

    @Component({
    selector: 'app-user-detail',
    templateUrl: './user-detail.component.html',
    styleUrls: ['./user-detail.component.css']
    })
    export class UserDetailComponent implements OnInit {

        @Input() user: UserDTO;
    constructor(
  private route: ActivatedRoute,
  private userService: UserService,
  private location: Location
) {}

   ngOnInit(): void {
  this.read();
}

    read(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.userService.read(id)
    .subscribe(user => this.user = user);
    }

    goBack(): void {
    this.location.back();
    }
}
