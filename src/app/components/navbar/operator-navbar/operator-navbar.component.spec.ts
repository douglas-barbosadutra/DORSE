import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OperatorNavbarComponent } from './operator-navbar.component';

describe('OperatorNavbarComponent', () => {
  let component: OperatorNavbarComponent;
  let fixture: ComponentFixture<OperatorNavbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OperatorNavbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OperatorNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
