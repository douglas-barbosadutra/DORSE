import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SuperuserNavbarComponent } from './superuser-navbar.component';

describe('SuperuserNavbarComponent', () => {
  let component: SuperuserNavbarComponent;
  let fixture: ComponentFixture<SuperuserNavbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SuperuserNavbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SuperuserNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
