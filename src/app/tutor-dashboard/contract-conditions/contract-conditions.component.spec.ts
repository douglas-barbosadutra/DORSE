import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ContractConditionsComponent } from './contract-conditions.component';

describe('ContractConditionsComponent', () => {
  let component: ContractConditionsComponent;
  let fixture: ComponentFixture<ContractConditionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ContractConditionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ContractConditionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
