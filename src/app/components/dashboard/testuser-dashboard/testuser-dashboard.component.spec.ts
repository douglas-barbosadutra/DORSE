import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TestuserDashboardComponent } from './testuser-dashboard.component';

describe('TestuserDashboardComponent', () => {
  let component: TestuserDashboardComponent;
  let fixture: ComponentFixture<TestuserDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TestuserDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TestuserDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
