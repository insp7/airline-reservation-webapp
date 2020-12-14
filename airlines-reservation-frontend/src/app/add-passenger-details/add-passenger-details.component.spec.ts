import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPassengerDetailsComponent } from './add-passenger-details.component';

describe('AddPassengerDetailsComponent', () => {
  let component: AddPassengerDetailsComponent;
  let fixture: ComponentFixture<AddPassengerDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddPassengerDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddPassengerDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
