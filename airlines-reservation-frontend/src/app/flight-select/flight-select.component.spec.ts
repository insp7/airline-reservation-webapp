import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightSelectComponent } from './flight-select.component';

describe('FlightSelectComponent', () => {
  let component: FlightSelectComponent;
  let fixture: ComponentFixture<FlightSelectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FlightSelectComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FlightSelectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
